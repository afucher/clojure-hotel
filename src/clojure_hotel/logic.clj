(ns clojure-hotel.logic)

(defn total-de-diarias
    [dias hotel tipo-cliente tipo-dia]
    (->> hotel
        tipo-cliente
        tipo-dia
        (* dias)))

(defn total-para-semana-normal
    [dias hotel]
    (total-de-diarias dias hotel :regular :week))

(defn total-para-fds-normal
    [dias hotel]
    (total-de-diarias dias hotel :regular :weekend))

(defn total-para-semana-reward
    [dias hotel]
    (total-de-diarias dias hotel :reward :week))

(defn total-para-fds-reward
    [dias hotel]
    (total-de-diarias dias hotel :reward :weekend))

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

(defn eh-melhor? 
  [primeira-opcao segunda-opcao]
  (< (:valor primeira-opcao) (:valor segunda-opcao)))

(defn melhor-hotel-reward
  [hoteis estadia]
  (->> hoteis
    (map (fn [hotel] {:hotel hotel :valor (total-para-reward estadia hotel)}))
    (reduce (fn [prev, curr] (if (eh-melhor? prev curr)
      prev
      curr)))
    :hotel))
  



