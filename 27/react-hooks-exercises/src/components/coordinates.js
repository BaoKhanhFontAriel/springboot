import React, {useEffect, useState } from "react";

function Coordinates() {
  const [
    mousePosition,
    setMousePosition
  ] = useState({ x: null, y: null });

  useEffect(() => {
    const updateMousePosition = ev => {
      setMousePosition({ x: ev.clientX, y: ev.clientY });
    };
    
    window.addEventListener('mousemove', updateMousePosition);

    return () => {
      window.removeEventListener('mousemove', updateMousePosition);
    };
  }, []);


  return (
    <div>
      <p>
        {mousePosition.x} - {mousePosition.y}
      </p>
    </div>
  );
}

export default Coordinates;