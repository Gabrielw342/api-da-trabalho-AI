export function getUsuarioLogado() {
  return JSON.parse(localStorage.getItem("usuarioLogado") || "null");
}

export function estaLogado() {
  return !!getUsuarioLogado();
}