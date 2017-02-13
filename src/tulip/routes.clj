(ns tulip.routes
  "This namespace keep routes of the JSON API"
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]
            [tulip.handlers :as res]))

(defroutes app-routes
  "API routes declared by compojure's macro"
  (POST "/users" request
        (let [name (or (get-in request [:params :name])
                       (get-in request [:body :name])
                       "John Doe")]
          {:status 200
           :body {:name name
                  :desc (str "The name you sent to me was " name)}}))
  
  (route/resources "/")
  (route/not-found {:status 404
                    :body {:errors "Not found"}}))
