//package cn.acvrock;
//
///*
// * Copyright (c) 2014, Oracle America, Inc.
// * All rights reserved.
// *
// * Redistribution and use in source and binary forms, with or without
// * modification, are permitted provided that the following conditions are met:
// *
// *  * Redistributions of source code must retain the above copyright notice,
// *    this list of conditions and the following disclaimer.
// *
// *  * Redistributions in binary form must reproduce the above copyright
// *    notice, this list of conditions and the following disclaimer in the
// *    documentation and/or other materials provided with the distribution.
// *
// *  * Neither the name of Oracle nor the names of its contributors may be used
// *    to endorse or promote products derived from this software without
// *    specific prior written permission.
// *
// * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
// * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
// * THE POSSIBILITY OF SUCH DAMAGE.
// */
//
//
//import org.openjdk.jol.info.ClassLayout;
//import org.openjdk.jol.vm.VM;
//
//import static java.lang.System.out;
//
///**
// * @author Aleksey Shipilev
// */
//public class JOLSample_12_ThinLocking {
//
//    /*
//     * This is another dive into the mark word.
//     *
//     * Among other things, mark words store locking information.
//     * We can clearly see how the mark word contents change when
//     * we acquire the lock, and release it subsequently.
//     *
//     * This one is the example of thin (displaced) lock. The data
//     * in mark word when lock is acquired is the reference to the
//     * displaced object header, allocated on stack. Once we leave
//     * the lock, the displaced header is discarded, and mark word
//     * is reverted to the default value.
//     */
//
//    public static void main(String[] args) throws Exception {
//        out.println(VM.current().details());
//
//        final A a = new A();
//
//        ClassLayout layout = ClassLayout.parseInstance(a);
//
//        out.println("**** Fresh object");
//        out.println(layout.toPrintable());
//
//        synchronized (a) {
//            out.println("**** With the lock");
//            out.println(layout.toPrintable());
//        }
//
//        out.println("**** After the lock");
//        out.println(layout.toPrintable());
//    }
//
//    public static class A {
//        // no fields
//    }
//
//}