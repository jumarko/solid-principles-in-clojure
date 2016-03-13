(ns solid-principles-in-clojure.dependency-inversion)

;;; Dependency Inversion principle
;;; Higher level module should not depend on lower level module directly
;;; Instead it should depend on abstraction (interface)

;; Clojure uses DI everywhere - e.g. map function depends on clojure.lang.IFn interface and seq abstraction
(map (fn [x] (* x 3))
     [1 2 3])
