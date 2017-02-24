(ns tulip.db
  "Database related functions"
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:import org.bson.types.ObjectId))

;; Connect to localhost with defaut port
;; Create an instance of the database
(def ^:dynamic *conn* (mg/connect{:host "193.239.248.170"}))
(def ^:dynamic *db* (mg/get-db *conn* "hives"))

(defn hive-insert-schema [hive temp weight humidity]
  "Insert hive's post values in the database"
  (let [date  (.toString (java.util.Date.))]
    (mc/insert *db* "hive" {:instance hive
                           :date date
                           :values{:temperature temp
                                   :weight weight
                                   :humidity humidity}})))
(defn hive-last-values [hive]
  "Sort last values from hive instance"
  (mc/find *db* "hive" {:instance hive}))