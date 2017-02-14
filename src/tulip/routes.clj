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
  (GET "/hive/:id/status" [id] (res/get-hive-status id))
  (POST "/testing" request (res/extract request))
  (route/resources "/")
  (route/not-found {:status 404
                    :body{:error "Not found"}}))
