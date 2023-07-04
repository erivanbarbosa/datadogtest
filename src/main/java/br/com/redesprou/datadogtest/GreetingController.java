package br.com.redesprou.datadogtest;

import java.util.Collection;
import java.util.Collections;

import datadog.trace.api.GlobalTracer;
import datadog.trace.api.interceptor.MutableSpan;
import datadog.trace.api.interceptor.TraceInterceptor;

public class GreetingController {

   static {
       GlobalTracer.get().addTraceInterceptor(new TraceInterceptor() {

           @Override
           public Collection<? extends MutableSpan> onTraceComplete(Collection<? extends MutableSpan> trace) {
               for (MutableSpan span : trace) {
                   if ("GET /health".contentEquals(span.getResourceName())) {
                       return Collections.emptyList();
                   }
               }
               return trace;
           }

           @Override
           public int priority() {
               return 200;  // Some unique number
           }
       });
   }
}