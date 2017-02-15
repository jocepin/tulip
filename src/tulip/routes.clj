(ns tulip.routes
  "This namespace keep routes of the JSON API"
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]
            [tulip.handlers :as res]))

(defroutes app-routes
  "API routes declared by compojure's macro"
  (GET "/" [] res/api-infos)
  ;; Hive post endpoint
  (GET "/endpoint" [] res/endpoint-info)
  (POST "/endpoint" [] {:body {:foo "bar"}})
  ;; Hive related Routes
  (GET "/hive" [] res/hive-infos)
  (GET "/hive/:id" [id] (res/get-hive-status id id))
  (GET "/hive/:id/temperature" [id] (res/get-hive-temperature id))
  (GET "/hive/:id/weight" [id] (res/get-hive-weight id))
  (GET "/hive/:id/humidity" [id] (res/get-hive-humidity id))
  ;; Compojure related routes
  (route/resources "/")
  (route/not-found {:status 404
                    :body{:error "Not found"}}))
