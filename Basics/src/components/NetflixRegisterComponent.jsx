export default function NetflixRegisterComponent() {
  return (
    <>
      <div>
        <p>
          Ready to Watch?
        </p>
        <div className="input-group input-group-lg">
          <input
            className="border border-black py-2 px-7 form-control"
            type="email"
          />
          <button className="btn btn-danger ms-1">
            {" "}
            Get Started
            <span className="bi bi-chevron-right"></span>
          </button>
        </div>
      </div>
    </>
  );
}
