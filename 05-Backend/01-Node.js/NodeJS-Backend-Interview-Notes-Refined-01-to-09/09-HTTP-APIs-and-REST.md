# 09 — HTTP, APIs and REST

## 1. What is an API?

An **API (Application Programming Interface)** defines how one software component uses another component's functionality. An API may be local or network-based. A network API commonly defines endpoints/operations, input, output and error behavior.

## 2. HTTP request and response

| Request component | Purpose |
|---|---|
| Method | Intended action (`GET`, `POST`, etc.) |
| URL/target | Resource or endpoint |
| Headers | Metadata such as authorization and content type |
| Body (optional) | Data sent by the client |

A response contains a status code, headers and optionally a body.

```http
POST /api/posts HTTP/1.1
Content-Type: application/json
Authorization: Bearer <token>

{"text":"Hello"}
```

`Content-Type` describes the body format. HTTPS protects HTTP traffic with TLS; authentication/authorization and input validation are still application responsibilities.

## 3. HTTP methods

| Method | Typical intent | Safe? | Idempotent? |
|---|---|---:|---:|
| GET | Retrieve a representation | Yes | Yes |
| POST | Submit/process/create | No | Usually no |
| PUT | Create/replace target representation | No | Intended yes |
| PATCH | Partially modify | No | Depends on operation |
| DELETE | Remove target resource | No | Intended yes |

- **Safe:** intended effect is read-only.
- **Idempotent:** repeating the same request has the same intended effect as performing it once.

## 4. REST-style endpoints

REST is an architectural style. A common RESTful HTTP API models resources in URLs and uses HTTP method semantics.

| Operation | Example |
|---|---|
| List posts | `GET /api/posts` |
| Get post 42 | `GET /api/posts/42` |
| Create post | `POST /api/posts` |
| Update selected fields | `PATCH /api/posts/42` |
| Delete post | `DELETE /api/posts/42` |

Use resource-oriented paths, appropriate status codes, consistent representations and stateless requests. Returning JSON alone does not automatically make an API fully RESTful.

## 5. Status codes to know

| Code | Meaning | Example |
|---|---|---|
| `200` | OK | Successful read/update |
| `201` | Created | New resource created |
| `204` | No Content | Success with no response body |
| `400` | Bad Request | Invalid request input |
| `401` | Unauthorized | Missing/invalid authentication credentials |
| `403` | Forbidden | Caller lacks permission |
| `404` | Not Found | Resource/route missing |
| `409` | Conflict | Request conflicts with current state |
| `429` | Too Many Requests | Rate limit exceeded |
| `500` | Internal Server Error | Unexpected server failure |
| `503` | Service Unavailable | Temporarily unable to serve |

Broad groups: **2xx success · 3xx redirection · 4xx request/client issue · 5xx server issue**.

## 6. API styles

| Style | Main idea |
|---|---|
| REST | Resource-oriented HTTP interfaces |
| GraphQL | Client selects fields through a schema/query language |
| gRPC | Typed RPC framework commonly using Protocol Buffers and HTTP/2 |
| SOAP | XML-based messaging protocol with formal service conventions |

Use-case and ecosystem determine which style fits best.

## 7. JSON and serialization

**Serialization** converts data into a transferable/storable format; deserialization reconstructs usable data.

```js
const text = JSON.stringify({ id: 42 });
const value = JSON.parse(text);
```

Not every body is JSON. File uploads commonly use `multipart/form-data`; binary payloads can use binary formats. Base64 encodes binary data as text but increases payload size.

## 8. HTTP versions

| Version | Interview-level distinction |
|---|---|
| HTTP/1.1 | Text-based messages; supports persistent connections |
| HTTP/2 | Binary framing and multiplexed streams over TCP |
| HTTP/3 | Uses QUIC over UDP; independent streams avoid TCP-level head-of-line blocking between streams |

Do not say HTTP/2 eliminates every kind of head-of-line blocking: loss at the TCP layer can still affect streams on that connection.

## Interview checks

**API vs. network API?** An API is any defined software interface; a network API communicates across a network.

**GET vs. POST?** GET is intended for safe retrieval; POST submits data or triggers processing and is not generally idempotent.

**PUT vs. PATCH?** PUT usually replaces a target representation; PATCH applies partial changes.

**401 vs. 403?** Authentication credentials are missing/invalid vs. operation is not permitted.

**400 vs. 500?** Invalid/request problem vs. unexpected server-side failure.

**What is REST?** An architectural style; RESTful HTTP APIs commonly model resources and use HTTP semantics/stateless interactions.

**What is serialization?** Converting data into a transferable/storable representation.

## Remember

For interviews, be ready to design resource endpoints, choose methods/status codes, explain headers and bodies, and compare REST with GraphQL/gRPC at a high level.
