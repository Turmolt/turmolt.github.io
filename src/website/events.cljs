(ns website.events
 (:require
  [re-frame.core :as re-frame]
  [website.db :as db]
  [reitit.frontend.controllers :as rfc]
  [reitit.frontend.easy :as rfe]))

(defn track-page-view [page-name]
  (when (exists? js/gtag)
    (js/gtag "event" "page_view"
             #js {:page_title page-name
                  :page_location (str js/location.origin "/#" page-name)})))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-fx
 ::navigate
 (fn [db [_ & route]]
   {::navigate! route}))

(re-frame/reg-event-fx
 ::navigate!
 (fn [route]
   (apply rfe/push-state route)))

(re-frame/reg-event-db
 ::navigated
 (fn [db [_ new-match]]
   (let [old-match (:page db)
         controllers (rfc/apply-controllers (:controllers old-match) new-match)
         page-name (get-in new-match [:data :name])]
     (track-page-view (name page-name))
     (assoc db :page (assoc new-match :controllers controllers)))))