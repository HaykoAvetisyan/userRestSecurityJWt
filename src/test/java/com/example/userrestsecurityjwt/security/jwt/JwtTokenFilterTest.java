package com.example.userrestsecurityjwt.security.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.DelegatingServletInputStream;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.support.StandardServletEnvironment;

class JwtTokenFilterTest {
    /**
     * Method under test: {@link JwtTokenFilter#JwtTokenFilter(JwtTokenProvider)}
     */
    @Test
    void testConstructor() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: Failed to load ApplicationContext
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:958)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:127)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:502)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:488)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:543)
        //   org.mockito.exceptions.base.MockitoException:
        //   Cannot mock/spy long
        //   Mockito cannot mock/spy because :
        //    - primitive type
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:958)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:127)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:502)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:488)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:543)
        //   See https://diff.blue/R026 to resolve this issue.

        JwtTokenFilter actualJwtTokenFilter = new JwtTokenFilter(new JwtTokenProvider());
        assertTrue(actualJwtTokenFilter.getEnvironment() instanceof StandardServletEnvironment);
        assertNull(actualJwtTokenFilter.getFilterConfig());
    }

    /**
     * Method under test: {@link JwtTokenFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
     */
    @Test
    void testDoFilter() throws IOException, ServletException {
        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(new JwtTokenProvider());
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        Response res = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        jwtTokenFilter.doFilter(mockHttpServletRequest, res, filterChain);
        verify(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        assertFalse(mockHttpServletRequest.isRequestedSessionIdFromURL());
        assertTrue(mockHttpServletRequest.isRequestedSessionIdFromCookie());
        assertFalse(mockHttpServletRequest.isAsyncSupported());
        assertFalse(mockHttpServletRequest.isAsyncStarted());
        assertTrue(mockHttpServletRequest.isActive());
        assertTrue(mockHttpServletRequest.getSession() instanceof MockHttpSession);
        assertEquals("", mockHttpServletRequest.getServletPath());
        assertEquals(80, mockHttpServletRequest.getServerPort());
        assertEquals("localhost", mockHttpServletRequest.getServerName());
        assertEquals("http", mockHttpServletRequest.getScheme());
        assertEquals("", mockHttpServletRequest.getRequestURI());
        assertEquals(80, mockHttpServletRequest.getRemotePort());
        assertEquals("localhost", mockHttpServletRequest.getRemoteHost());
        assertEquals("HTTP/1.1", mockHttpServletRequest.getProtocol());
        assertEquals("", mockHttpServletRequest.getMethod());
        assertEquals(80, mockHttpServletRequest.getLocalPort());
        assertEquals("localhost", mockHttpServletRequest.getLocalName());
        assertTrue(mockHttpServletRequest.getInputStream() instanceof DelegatingServletInputStream);
        assertEquals(DispatcherType.REQUEST, mockHttpServletRequest.getDispatcherType());
        assertEquals("", mockHttpServletRequest.getContextPath());
        assertEquals(-1L, mockHttpServletRequest.getContentLengthLong());
    }

    /**
     * Method under test: {@link JwtTokenFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilter2() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.userrestsecurityjwt.security.jwt.JwtTokenFilter.doFilter(JwtTokenFilter.java:26)
        //   In order to prevent doFilter(ServletRequest, ServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilter(ServletRequest, ServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(null);
        MockHttpServletRequest req = new MockHttpServletRequest();
        Response res = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        jwtTokenFilter.doFilter(req, res, filterChain);
    }

    /**
     * Method under test: {@link JwtTokenFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilter3() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.userrestsecurityjwt.security.jwt.JwtTokenProvider.resolveToken(JwtTokenProvider.java:72)
        //       at com.example.userrestsecurityjwt.security.jwt.JwtTokenFilter.doFilter(JwtTokenFilter.java:26)
        //   In order to prevent doFilter(ServletRequest, ServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilter(ServletRequest, ServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(new JwtTokenProvider());
        Response res = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        jwtTokenFilter.doFilter(null, res, filterChain);
    }

    /**
     * Method under test: {@link JwtTokenFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
     */
    @Test
    void testDoFilter4() throws IOException, ServletException {
        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(new JwtTokenProvider());
        MockHttpServletRequest req = new MockHttpServletRequest();
        Response res = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doThrow(new JwtAuthenticationException("Authorization")).when(filterChain)
                .doFilter((ServletRequest) any(), (ServletResponse) any());
        assertThrows(JwtAuthenticationException.class, () -> jwtTokenFilter.doFilter(req, res, filterChain));
        verify(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
    }
}

