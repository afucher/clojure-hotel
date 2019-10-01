(ns clojure-hotel.logic)

(defn total-para-semana-normal
    [dias hotel]
    (->> hotel
        :regular
        :week
        (* dias)))

(defn total-para-fds-normal
    [dias hotel]
    (->> hotel
        :regular
        :weekend
        (* dias)))

(defn total-para-semana-reward
    [dias hotel]
    (->> hotel
        :reward
        :week
        (* dias)))

(defn total-para-fds-reward
    [dias hotel]
    (->> hotel
        :reward
        :weekend
        (* dias)))