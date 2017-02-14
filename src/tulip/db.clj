(ns tulip.db
  "Database related functions"
  (:require [monger.core :as mg]))

;; Connect to localhost with defaut port
;; Create an instance of the database
(let [conn (mg/connect)
      db (mg/get-db conn "hives")])
