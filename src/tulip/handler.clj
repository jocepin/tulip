(ns tulip.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]
            [tulip.routes :as routes]))

(def app
  (-> (handler/site routes/app-routes)
      (middleware/wrap-json-body {:keywords? true})
       middleware/wrap-json-response))
