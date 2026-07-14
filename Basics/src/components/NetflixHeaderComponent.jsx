export default function NetflixHeaderComponent() {
  return (
    <>
    <div className="header">
      <div>
        <h2 className="text-danger">NETFLIX</h2>
        </div>
        <div className="input-group w-auto">
          <select name="" id="" className="form-select">
            <option value="">Language</option>
            <option value="">English</option>
            <option value="">Hindi</option>
          </select>
          <button className="btn btn-danger ms-2">Sign In</button>

        </div>
    </div>
    </>
  )
}