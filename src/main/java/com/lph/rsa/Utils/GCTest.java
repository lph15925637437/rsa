package com.lph.rsa.Utils;


import net.sf.cglib.proxy.Enhancer;

public class GCTest {

    public static void main(String[] args) throws InterruptedException {

        Enhancer enhancer = CGLibUtil.interceptor(Car.class, false, "run");

        Car car = (Car) enhancer.create();
        car.run();

        Enhancer enhancer1 = CGLibUtil.interceptor(Car.class, false, "excute");

        Car car1 = (Car) enhancer1.create();
        car1.excute();
    }

    static class Car {

        public void run() {
            System.err.println("run执行开始");
        }

        public void excute() {
            System.err.println("excute执行开始");
        }
    }
}
