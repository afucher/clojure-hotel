(ns clojure-hotel.core
  (:require [clojure-hotel.db :as h.db])
  (:require [clojure-hotel.logic :as h.logic])
  (:use clojure.pprint))

(println h.db/lakewood)

(println "Total para 3 dias no lakewood" 
  (h.logic/total-para-semana-normal 3 h.db/lakewood))

(pprint (h.logic/melhor-hotel-reward [h.db/lakewood, h.db/bridgewood] {:week 1 :weekend 1}))