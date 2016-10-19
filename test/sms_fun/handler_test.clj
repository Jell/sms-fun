(ns sms-fun.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [sms-fun.handler :refer :all]))

(deftest test-app
  (testing "sms"
    (let [response (app (mock/request :post "/sms" {:from "from"
                                                    :to "to"
                                                    :message "message"}))]
      (is (= (:status response) 200))
      (is (= (:body response) "From: from, to: to, message: message"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
