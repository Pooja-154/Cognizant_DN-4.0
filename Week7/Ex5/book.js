import React from 'react';

const BookDetails = ({ books }) => {
  return (
    <div>
      <h2>Book Details</h2>
      <ul>
        {books.map((book, index) => (
          <li key={index}>
            📘 <strong>{book.title}</strong> by {book.author}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BookDetails;
