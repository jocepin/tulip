(ns tulip.handlers
  "This namespace contain all handling
   functions for routes responses"
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]
            [monger.collection :as mc]
            [monger.core :as mg]
            [tulip.db :as db]))

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
               :version (System/getProperty "tulip.version")
               :date (.toString (java.util.Date.))}}})  
;; Hive Post Endpoint
(def endpoint-info
  "Informations about the endpoint"
  {:status 200
   :body{:desc "This endpoint retrieve hive information through http POST method"
         :date (.toString(java.util.Date.))
         :parameters{:hive "The hive name, must be a string"
                     :date "The date. Will be provided by the API but optional"
                     :values{:temperature "An integer to represent actual hive temperature"
                             :weight "An unsigned integer to represent the total hive weight"
                             :humidity "An integer to represent the actual humidity, in %"}}}})

(defn hive-input [hive temperature weight humidity]
  "Retrieve parameters from hive request and parse
   data through the database."
    {:status 200
     :body{:hive hive
           :status "ok"
           :values{:temperature temperature
                   :weight weight
                   :humidity humidity}
           :date (.toString(java.util.Date.))}})

;; Hive related functions
(def hive-infos
  "Informations about the /hive route"
  {:status 200
   :body {:desc "This route make easier to retrieve values from database."
          :available{:weight{:route "/hive/:id/weight"
                             :desc "Return 10 last weight values."}
                     :temperature{:route "/hive/:id/temperature"
                                  :desc "Return 10 last temperature values."}
                     :humidity{:route "/hive/:id/humidity"
                               :desc "Return 10 last humidity values"}}}})
(defn get-hive-status [id]
  "Return to JSON the status of the selected hive"
  {:status 200
   :body {:id id
          :status "Get the status of the hive"}})

(defn get-hive-temperature [id]
  "Return 10 last temperature values recorded in the database"
  {:status 200
   :body {:id id
          :desc "Get the 10 last temperature values"}})

(defn get-hive-weight [id]
  "Return 10 last weight values recorded in the database"
  {:status 200
   :body {:id id
          :desc "Get the 10 last weight values"}})

(defn get-hive-humidity [id]
  "Return 10 last humidity values recorded in the database"
  {:status 200
   :body {:id id
          :desc "Get the 10 last humidity values"}})
