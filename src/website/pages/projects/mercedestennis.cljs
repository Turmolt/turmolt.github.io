(ns website.pages.projects.mercedestennis
 (:require 
  [website.pages.common :refer [link iframe canvas]]))


(def title "US Open Mixed Reality Tennis")
(def body-preview "A mixed reality multiplayer tennis game that was showcased at the US Open")
(def date "June 2019")
(def body 
  [:div {:style {:font-size 18 :line-height 1.4}} 
   [:img {:src "/turmolt.github.io/public/resources/US_Open.png"
             :style {:width 660 :height 660 :margin-top 20 :float :center}}]
   [:br] [:br] "I developed a Mixed Reality Tennis application showcased at the 2019 US Open. This multiplayer application featured multiple participants competing with dynamic visual effects."
   [:br] [:br] "The application was built in Unity and utilized a variety of screens and mixed reality peripherals. The setup included two stations with VR tracking pucks attached to tennis rackets, a tablet, and a large LED wall displaying the game state with prominent visual effects. Communication between devices was handled by a custom TCP Client/Server plugin I developed."
   [:br][:br]
   [iframe {:src "https://www.youtube.com/embed/FbrmlQQ7f9M"
            :name "US Open Virtual Tennis"}] 
   [:br] [:br] "I was responsible for all aspects of the project except swing detection, including gameplay, networking, and visual effects. Using Houdini and Substance Designer, I created textures and flipbooks for the application."
   [:br] [:br] "I played a significant role in game design, handling all gameplay system design and implementation."
   [:br] [:br] "The top half of the screen shows the LED wall display, while the bottom half shows one of the player’s screens."])

(def tag :mercedes)
(def route "Mercedes Tennis")

(defn icon []
  [:img {:src "/turmolt.github.io/public/resources/US_Open.png" :style {:width 60 :height 60 :margin 10 :margin-top 20 :float :left}}])

(defn panel []
  (set! (. js/document -title) title)
  [:div
   {:class "f400"
    :style {:width 700 :margin :auto}}
   [:h2 title]
   [:p {:style {:padding 0 :font-size 10 :margin-top -15}} date]
   [:div body]])


(def post {:name route
           :route (str "#/" route)
           :icon icon
           :title title
           :preview body-preview
           :panel panel
           :tag tag})