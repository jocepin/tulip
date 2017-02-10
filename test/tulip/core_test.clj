(ns tulip.core-test
  (:require [clojure.test :refer :all]
            [tulip.core :refer :all])
  (:use ring.mock.request 
        tulip.handler))

(deftest a-test
  (testing "Trivial test to accept travis build"
    (is (= 1 1))))

(deftest test-app
  (testing "Testing users POST ROUTE"
    (let [response (app (request :post "/users"))]
      (is (= (:status response) 200))
      (is (= (get-in response [:headers "Content-Type"]) "application-json"))))
  (testing "Testing 404 pages."
    (let [response (app (request :get "/bogus-route"))]
      (is (= (:status response) 404)))))
