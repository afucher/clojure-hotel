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

(defn total-para-normal
    [estadia hotel]
    (let  [ total-week (total-para-semana-normal (get estadia :week 0) hotel)
            total-weekend (total-para-fds-normal (get estadia :weekend 0) hotel)]
    (+ total-week total-weekend)))

(defn total-para-reward
  [estadia hotel]
  (let  [ total-week (total-para-semana-reward (get estadia :week 0) hotel)
          total-weekend (total-para-fds-reward (get estadia :weekend 0) hotel)]
  (+ total-week total-weekend)))