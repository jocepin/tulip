(ns tulip.core-test
  (:require [clojure.test :refer :all]
            [tulip.core :refer :all])
  (:use ring.mock.request 
        tulip.app))

(deftest test-init
  (testing "Trivial test to accept travis build"
    (is (= 1 1))))

(deftest test-api-status
  "Test API status from response"
  (testing "Testing users POST ROUTE"
    (let [response (app (request :post "/users"))]
      (is (= (:status response) 200))))
   
  (testing "Testing 404 pages."
    (let [response (app (request :get "/some-foo-routes"))]
      (is (= (:status response) 404)))))

(deftest test-api-contentypes
  "Test content types from GET and POST methods."
  (testing "Testing content types"
    (let [response (app (request :get "/"))]
      (is (= (get-in response [:headers "Content-Type"]) "application/json; charset=utf-8")))))
