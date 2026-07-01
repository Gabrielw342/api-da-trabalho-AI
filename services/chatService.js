import config from "./config";

export async function enviarMensagem(pergunta) {
  const response = await fetch(
    `${config.api.baseURL}${config.api.chatEndpoint}`,
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ pergunta }),
    }
  );

  if (!response.ok) {
    throw new Error("Erro ao se comunicar com o servidor");
  }

  const data = await response.json();
  return data.resposta; 
}