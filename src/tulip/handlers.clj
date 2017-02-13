3(ns tulip.handlers
  "This namespace contain all handling
   functions for routes responses"
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]))
