(ns tulip.app
  "This namespace is the main ring entry"
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]
            [tulip.routes :as routes]))

(def app
  "Main entry of the ring application, chaining
   middleware to make correct JSON response content type."
  (-> (handler/site routes/app-routes)
      (middleware/wrap-json-body {:keywords? true})
      middleware/wrap-json-response))
