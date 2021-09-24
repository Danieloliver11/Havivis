export interface Product {
    id?: number;
    nome: string;
    valor: number | null;
    descricao?: string;
    imagem?: string;
}