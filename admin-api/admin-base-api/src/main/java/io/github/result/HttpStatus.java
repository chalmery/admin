package io.github.result;

/**
 * HTTP状态码
 *
 * @see java.net.HttpURLConnection
 */
public class HttpStatus {

    /* 1XX: Informational */

    /**
     * HTTP 状态码 100：继续。
     */
    public static final int HTTP_CONTINUE = 100;

    /**
     * HTTP 状态码 101：切换协议。
     */
    public static final int HTTP_SWITCHING_PROTOCOLS = 101;

    /**
     * HTTP 状态码 102：处理中。
     */
    public static final int HTTP_PROCESSING = 102;

    /**
     * HTTP 状态码 103：检查点。
     */
    public static final int HTTP_CHECKPOINT = 103;

    /* 2XX: 通常表示“OK” */

    /**
     * HTTP 状态码 200：成功。
     */
    public static final int HTTP_OK = 200;

    /**
     * HTTP 状态码 201：已创建。
     */
    public static final int HTTP_CREATED = 201;

    /**
     * HTTP 状态码 202：已接受。
     */
    public static final int HTTP_ACCEPTED = 202;

    /**
     * HTTP 状态码 203：非权威信息。
     */
    public static final int HTTP_NOT_AUTHORITATIVE = 203;

    /**
     * HTTP 状态码 204：无内容。
     */
    public static final int HTTP_NO_CONTENT = 204;

    /**
     * HTTP 状态码 205：重置内容。
     */
    public static final int HTTP_RESET = 205;

    /**
     * HTTP 状态码 206：部分内容。
     */
    public static final int HTTP_PARTIAL = 206;

    /**
     * HTTP 状态码 207：多状态。
     */
    public static final int HTTP_MULTI_STATUS = 207;

    /**
     * HTTP 状态码 208：已经报告。
     */
    public static final int HTTP_ALREADY_REPORTED = 208;

    /**
     * HTTP 状态码 226：IM 已使用。
     */
    public static final int HTTP_IM_USED = 226;

    /* 3XX: 重定向/搬迁 */

    /**
     * HTTP 状态码 300：多种选择。
     */
    public static final int HTTP_MULT_CHOICE = 300;

    /**
     * HTTP 状态码 301：永久移动。
     */
    public static final int HTTP_MOVED_PERM = 301;

    /**
     * HTTP 状态码 302：临时重定向。
     */
    public static final int HTTP_MOVED_TEMP = 302;

    /**
     * HTTP 状态码 303：查看其他位置。
     */
    public static final int HTTP_SEE_OTHER = 303;

    /**
     * HTTP 状态码 304：未修改。
     */
    public static final int HTTP_NOT_MODIFIED = 304;

    /**
     * HTTP 状态码 305：使用代理。
     */
    public static final int HTTP_USE_PROXY = 305;

    /**
     * HTTP 1.1 状态码 307：临时重定向。<br>
     * 参考：RFC-7231
     */
    public static final int HTTP_TEMP_REDIRECT = 307;

    /**
     * HTTP 1.1 状态码 308：永久重定向<br>
     * 参考：RFC-7231
     */
    public static final int HTTP_PERMANENT_REDIRECT = 308;

    /* 4XX: 客户端错误 */

    /**
     * HTTP 状态码 400：错误请求。
     */
    public static final int HTTP_BAD_REQUEST = 400;

    /**
     * HTTP 状态码 401：未经授权。
     */
    public static final int HTTP_UNAUTHORIZED = 401;

    /**
     * HTTP 状态码 402：需要付款。
     */
    public static final int HTTP_PAYMENT_REQUIRED = 402;

    /**
     * HTTP 状态码 403：禁止访问。
     */
    public static final int HTTP_FORBIDDEN = 403;

    /**
     * HTTP 状态码 404：未找到。
     */
    public static final int HTTP_NOT_FOUND = 404;

    /**
     * HTTP 状态码 405：方法不允许。
     */
    public static final int HTTP_BAD_METHOD = 405;

    /**
     * HTTP 状态码 406：不可接受。
     */
    public static final int HTTP_NOT_ACCEPTABLE = 406;

    /**
     * HTTP 状态码 407：需要代理身份验证。
     */
    public static final int HTTP_PROXY_AUTH = 407;

    /**
     * HTTP 状态码 408：请求超时。
     */
    public static final int HTTP_CLIENT_TIMEOUT = 408;

    /**
     * HTTP 状态码 409：冲突。
     */
    public static final int HTTP_CONFLICT = 409;

    /**
     * HTTP 状态码 410：已删除。
     */
    public static final int HTTP_GONE = 410;

    /**
     * HTTP 状态码 411：必须指定内容长度。
     */
    public static final int HTTP_LENGTH_REQUIRED = 411;

    /**
     * HTTP 状态码 412：前提条件失败。
     */
    public static final int HTTP_PRECON_FAILED = 412;

    /**
     * HTTP 状态码 413：请求实体过大。
     */
    public static final int HTTP_ENTITY_TOO_LARGE = 413;

    /**
     * HTTP 状态码 414：请求 URI 过长。
     */
    public static final int HTTP_REQ_TOO_LONG = 414;

    /**
     * HTTP 状态码 415：不支持的媒体类型。
     */
    public static final int HTTP_UNSUPPORTED_TYPE = 415;

    /**
     * HTTP 状态码 416：请求范围不符合要求。
     */
    public static final int HTTP_REQUESTED_RANGE_NOT_SATISFIABLE = 416;

    /**
     * HTTP 状态码 417：预期失败。
     */
    public static final int HTTP_EXPECTATION_FAILED = 417;

    /**
     * HTTP 状态码 418：我是一个茶壶。
     */
    public static final int HTTP_I_AM_A_TEAPOT = 418;

    /**
     * HTTP 状态码 422：无法处理的实体。
     */
    public static final int HTTP_UNPROCESSABLE_ENTITY = 422;

    /**
     * HTTP 状态码 423：锁定。
     */
    public static final int HTTP_LOCKED = 423;

    /**
     * HTTP 状态码 424：依赖失败。
     */
    public static final int HTTP_FAILED_DEPENDENCY = 424;

    /**
     * HTTP 状态码 425：过早请求。
     */
    public static final int HTTP_TOO_EARLY = 425;

    /**
     * HTTP 状态码 426：需要升级。
     */
    public static final int HTTP_UPGRADE_REQUIRED = 426;

    /**
     * HTTP 状态码 428：需要前提条件。
     */
    public static final int HTTP_PRECONDITION_REQUIRED = 428;

    /**
     * HTTP 状态码 429：请求过多。
     */
    public static final int HTTP_TOO_MANY_REQUESTS = 429;

    /**
     * HTTP 状态码 431：请求头字段过大。
     */
    public static final int HTTP_REQUEST_HEADER_FIELDS_TOO_LARGE = 431;

    /**
     * HTTP 状态码 451：因法律原因不可用。
     */
    public static final int HTTP_UNAVAILABLE_FOR_LEGAL_REASONS = 451;

    /* 5XX: 服务器错误 */

    /**
     * HTTP 状态码 500：内部服务器错误。
     */
    public static final int HTTP_INTERNAL_ERROR = 500;

    /**
     * HTTP 状态码 501：未实现。
     */
    public static final int HTTP_NOT_IMPLEMENTED = 501;

    /**
     * HTTP 状态码 502：错误网关。
     */
    public static final int HTTP_BAD_GATEWAY = 502;

    /**
     * HTTP 状态码 503：服务不可用。
     */
    public static final int HTTP_UNAVAILABLE = 503;

    /**
     * HTTP 状态码 504：网关超时。
     */
    public static final int HTTP_GATEWAY_TIMEOUT = 504;

    /**
     * HTTP 状态码 505：HTTP 版本不受支持。
     */
    public static final int HTTP_VERSION = 505;

    /**
     * HTTP 状态码 506：变体也需协商。
     */
    public static final int HTTP_VARIANT_ALSO_NEGOTIATES = 506;

    /**
     * HTTP 状态码 507：存储空间不足。
     */
    public static final int HTTP_INSUFFICIENT_STORAGE = 507;

    /**
     * HTTP 状态码 508：检测到循环。
     */
    public static final int HTTP_LOOP_DETECTED = 508;

    /**
     * HTTP 状态码 509：带宽超出限制。
     */
    public static final int HTTP_BANDWIDTH_LIMIT_EXCEEDED = 509;

    /**
     * HTTP 状态码 510：未扩展。
     */
    public static final int HTTP_NOT_EXTENDED = 510;

    /**
     * HTTP 状态码 511：需要网络身份验证。
     */
    public static final int HTTP_NETWORK_AUTHENTICATION_REQUIRED = 511;

    /**
     * 是否为重定向状态码
     *
     * @param responseCode 被检查的状态码
     * @return 是否为重定向状态码
     * @since 5.6.3
     */
    public static boolean isRedirected(int responseCode) {
        return responseCode == HTTP_MOVED_PERM
                || responseCode == HTTP_MOVED_TEMP
                || responseCode == HTTP_SEE_OTHER
                // issue#1504@Github，307和308是RFC 7538中http 1.1定义的规范
                || responseCode == HTTP_TEMP_REDIRECT
                || responseCode == HTTP_PERMANENT_REDIRECT;
    }
}