import React from 'react';

const CourseDetails = ({ courses }) => {
  return (
    <div>
      <h2>Course Details</h2>
      <ul>
        {courses.map((course, index) => (
          <li key={course.code}>
            📚 {course.name} ({course.code})
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CourseDetails;
