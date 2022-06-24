<template>
    <div class="mt-5 formulario">
        <h1 class="text-light">Ingresar una denuncia</h1>
        <form class="">
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label text-light d-flex">Correo institucional del
                    denunciante</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label text-light d-flex">Correo institucional del
                    denunciado</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label text-light d-flex">Contraseña</label>
                <input type="password" class="form-control" id="exampleInputPassword1">
            </div>

            <div class="mb-3">
                <label for="floatingTextarea" class="text-light d-flex">Detalles de la denuncia</label>
                <textarea class="form-control" placeholder="Detalles de la denuncia" id="floatingTextarea"></textarea>
            </div>
            <div class="mb-3">
                <label for="floatingTextarea" class="text-light d-flex">Medidas de proteccion (opcional)</label>
                <textarea class="form-control" placeholder="Medidas de proteccion" id="floatingTextarea"></textarea>
            </div>
            <button type="submit" class="btn btn-primary d-flex">Enviar</button>
        </form>
    </div>
</template>

<style>
.formulario{
    margin-bottom: 4rem;
    margin-left: 3rem;
    margin-right: 3rem;
}
</style>
