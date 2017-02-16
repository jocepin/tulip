(ns tulip.db
  "Database related functions"
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:import org.bson.types.ObjectId))

;; Connect to localhost with defaut port
;; Create an instance of the database
(def *conn* (mg/connect))
(def *db* (mg/get-db *conn* "hives"))

(defn hive-insert-schema [hive temp weight humidity]
  "Insert hive's post values in the database"
  (let [date  (.toString (java.util.Date.))]
    (mc/insert db "hive" {:instance hive
                           :date date
                           :values{:temperature temp
                                   :weight weight
                                   :humidity humidity}})))
