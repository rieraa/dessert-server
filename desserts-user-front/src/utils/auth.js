const getToken = () => {
  return localStorage.getItem('token');
};

const setToken = token => {
  localStorage.setItem('token', `${token}`);
};

const clearToken = () => {
    localStorage.clear();
}

export { getToken, setToken, clearToken };
