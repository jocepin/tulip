(ns tulip.routes
  "This namespace keep routes of the JSON API"
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]
            [tulip.handlers :as res]))

(defroutes app-routes
  "API routes declared by compojure's macro"
  (ANY "/" [] res/api-infos)
  ;; Hive post endpoint
  (GET "/endpoint" [] res/endpoint-info)
  (POST "/endpoint" request
        (let [hive (or (get-in request [:params :hive])
                       (get-in request [:body :hive])
                       nil)
              temp (or (get-in request [:params :temp])
                              (get-in request [:body :temp])
                              nil)
              weight (or (get-in request [:params :weight])
                         (get-in request [:body :weight])
                         nil)
              humidity (or (get-in request [:params :humidity])
                           (get-in request [:body :humidity])
                           nil)]
          (res/hive-input hive temp weight humidity)))
  ;; Hive related Routes
  (GET "/hive" [] res/hive-infos)
  (GET "/hive/:id" [id] (res/get-last-values id))
  (GET "/hive/:id/temperature" [id] (res/get-hive-temperature id))
  (GET "/hive/:id/weight" [id] (res/get-hive-weight id))
  (GET "/hive/:id/humidity" [id] (res/get-hive-humidity id))
  ;; Compojure related routes
  (route/resources "/")
  (route/not-found res/notfound-body))
