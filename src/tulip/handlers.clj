3(ns tulip.handlers
  "This namespace contain all handling
   functions for routes responses"
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]))

(def api-infos
  "Hash-map of the informations
   of the API, displayed when GET root."
  {:status 200
   ;;:headers {"Content-Type" "application/vnd.api+json"}
   :body{:api {:title "Tulip Web Api"
               :description "Flexible API to receive information from hive instances."
               :contact{:name "Clement Trosa"
                        :url "https://github.com/iomonad"
                        :email "iomonad@riseup.net"}
               :license{:name "Eclipse Public License"
                        :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
               :version (System/getProperty "tulip.version")}}})  

(defn extract [request]
  "Take in paramater full post parameters and extract thems
   to parse users input"
  (let [name (or (get-in request [:params :name])
                 (get-in request [:body :name])
                 "John Doe")]
    {:status 200
     :body {:name name
            :desc (str"Your name is " name)}}))
