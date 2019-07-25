(ns env.core-test
  (:require [env.core :as env]
            [clojure.test :refer [deftest is testing]]))


(deftest env-test
  (testing "it gets an env variable from .env"
    (is (= "hello" (env/env :hello))))

  (testing "it gets an env variable from the system"
    (is (some? (env/env :shell))))

  (testing "it gets an env variable from env.edn"
    (is (= "hello" (env/env :hello-env-edn))))

  (testing "it gets a tagged literal env variable from env.edn"
    (is (= "tagged" (env/env :a-tagged-variable)))))
