(ns solid-principles-in-clojure.single-responsibility
  [:require [clojure.string :as str]
            [clojure.java.jdbc :as sql]])

;;; used libraries
;;; - http://clojure-doc.org/articles/ecosystem/java_jdbc/home.html#an-overview

;;; Single Resposibility principle -> function should have one reason to change


(def db
  {:subprotocol "mysql"
   :subname "//127.0.0.1:3306/dp"
   :user "root"
   :password ""})

;; Following function does three things
(defn display-records []
  (let [records (sql/query db "SELECT * FROM test.person")
        record-string (str/join "\n" (for [r records]
                                       (str (:first_name r) " " (:last_name r) " - ID: " (:id r))))]
    (println record-string)))

;; After refactoring ....
(defn fetch-records []
  (sql/query db "SELECT * FROM test.person"))

(defn record->string [record]
  (str (:first_name record) " " (:last_name record) " - ID: " (:id record)))

(defn records->string [records]
  (str/join "\n" (map record->string records)))

(defn display-records []
  (-> (fetch-records)
      records->string
      println))
