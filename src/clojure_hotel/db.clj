(ns clojure-hotel.db)

(def lakewood { :regular {:week 110 :weekend 80}
                :reward  {:week 80  :weekend 80}})


(def bridgewood { :regular {:week 160 :weekend 60}
                  :reward  {:week 110 :weekend 50}})


(def lakewood { :regular {:week 220 :weekend 150}
                :reward  {:week 100  :weekend 40}})

(defn hoteis [lakewood bridgewood lakewood])