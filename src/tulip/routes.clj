(ns tulip.routes
  "This namespace keep routes of the JSON API"
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]
            [tulip.handlers :as res]))

(defroutes app-routes
  "API routes declared by compojure's macro"
  (POST "/testing" request (res/extract request))
  (GET "/" [] res/api-infos)
  (route/resources "/")
  (route/not-found {:status 404
                    :body{:error "Not found"}}))
