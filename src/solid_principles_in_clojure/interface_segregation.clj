(ns solid-principles-in-clojure.interface-segregation)

;;; Interface Segragation principle -> you should split up your interfaces
;;; into smaller interfaces so that they have one reason to change
(for [method (vec (.getMethods clojure.lang.Associative)) ]
 (println (.getName method)))
