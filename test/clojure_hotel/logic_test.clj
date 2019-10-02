(ns clojure-hotel.logic-test
    (:require [clojure.test :refer :all]
              [clojure-hotel.logic :refer :all :as h.logic]))
  
  (def hotel-test { :regular {:week 110 :weekend 90}
                    :reward  {:week 80  :weekend 80}})

  (deftest calcula-valores-de-estadia-por-tipo-de-cliente-e-dia
    (testing "Should return 220 for 2 week days on regular"
      (is (= 220 (h.logic/total-de-diarias 2 hotel-test :regular :week))))
    (testing "Should return 270 for 3 weekend days on regular"
      (is (= 270 (h.logic/total-de-diarias 3 hotel-test :regular :weekend)))))

  (deftest calcula-valores-de-estadia-por-tipo-e-regular
    (testing "Should return 220 for 2 week days on regular"
      (is (= 220 (h.logic/total-para-semana-normal 2 hotel-test))))
    (testing "Should return 270 for 3 weekend days on regular"
      (is (= 270 (h.logic/total-para-fds-normal 3 hotel-test)))))
  
  (deftest calcula-valores-de-estadia-por-tipo-e-reward
    (testing "Should return 160 for 2 week days on reward"
      (is (= 160 (h.logic/total-para-semana-reward 2 hotel-test))))
    (testing "Should return 320 for 4 weekend days on reward"
      (is (= 320 (h.logic/total-para-fds-reward 4 hotel-test)))))

  (deftest calcula-valores-de-estadia-normal
    (testing "Should return 200 for 1 week day and 1 weekend day on normal"
      (let [estadia {:week 1 :weekend 1}]
        (is (= 200 (h.logic/total-para-normal estadia hotel-test)))))
    (testing "Should return 0 for 0 days for empty days on normal"
      (let [estadia {}]
        (is (= 0 (h.logic/total-para-normal estadia hotel-test))))))

  (deftest calcula-valores-de-estadia-reward
    (testing "Should return 160 for 1 week day and 1 weekend day on reward"
      (let [estadia {:week 1 :weekend 1}]
        (is (= 160 (h.logic/total-para-reward estadia hotel-test)))))
    (testing "Should return 0 for 0 days for empty days on reward"
      (let [estadia {}]
        (is (= 0 (h.logic/total-para-reward estadia hotel-test))))))