(ns solid-principles-in-clojure.open-closed
  [:require [clojure.string :as str]
            [clojure.java.jdbc :as sql]])

;;; Open/Closed principle -> we should be able to extend functionality without changing the module source code
;;; This is something that Clojure does extremelly well -> we can extend existing protocols and classes
;;; without breaking existing code

(defprotocol ToDate
  (to-date [x] "converts input to java.util.Date"))

;; I can take the protocol and implement it with existing classes without modifying the classes themselves
(extend-protocol ToDate
  String                                                    ;; strings get parsed
  (to-date [s]
    (.parse (java.text.SimpleDateFormat. "ddMMyyy") s))
  Long                                                      ;; logs are unix timestamps
  (to-date [l]
    (java.util.Date. l))
  java.util.Date                                            ;; Dates are just returned
  (to-date [d] d))

(to-date "08082015")
(to-date 0)
(to-date (to-date 0))
