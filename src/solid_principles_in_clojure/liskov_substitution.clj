(ns solid-principles-in-clojure.liskov-substitution)

;;; Liskov Substitution principle - subclass should be able to be substituted for its superclass
;;; This principle is mostly about subclass hierarchies which are rate in Clojure
;;; But, Clojure is built on the class hierarchies of Java

;; E.g. APersistentMap has four different implementations with compatible characteristics
;; clojure.lang.APersistentMap

;; Implementations
(def person {:name "John" :surname "Travolta"})
(clojure.lang.PersistentArrayMap/create person)
(clojure.lang.PersistentHashMap/create person)
;; not sure how to create new instance of struct map
;; more about PersisteStructMap: http://www.pawfal.org/dave/blog/2011/01/clojure-frustrations/
;(clojure.lang.PersistentStructMap/create person)
(clojure.lang.PersistentTreeMap/create person)


