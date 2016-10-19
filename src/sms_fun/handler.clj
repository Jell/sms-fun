(ns sms-fun.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(defroutes app-routes
  (POST "/sms" {{:keys [from to message]} :params}
    (str "From: " from ", to: " to, ", message: " message))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes api-defaults))
