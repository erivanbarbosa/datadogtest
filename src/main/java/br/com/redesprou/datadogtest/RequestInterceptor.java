package br.com.redesprou.datadogtest;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import io.opentracing.Span;
import io.opentracing.util.GlobalTracer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      String token = request.getHeader("token");
      final Span span = GlobalTracer.get().activeSpan();
      span.setTag("header.token", token);
      
      return true; // Se retornar false, o processamento da requisição será interrompido
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Executa após o processamento do controlador, mas antes da renderização da resposta
        // Aqui você pode adicionar dados ao modelo (ModelAndView) ou realizar outras operações pós-processamento
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Executa após a conclusão do processamento da requisição e da renderização da resposta
        // Aqui você pode realizar operações de limpeza ou registro de métricas de desempenho
    }
}
