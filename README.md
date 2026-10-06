# Receitas da Casa 🍲

Aplicativo Android desenvolvido para a missão **"Seu Próprio App, com Navegação de Verdade"**.

## Tema escolhido

**Catálogo de Receitas**

O aplicativo funciona como um pequeno caderno digital de receitas, permitindo visualizar receitas, abrir seus detalhes e marcar receitas como favoritas.

## Telas implementadas

- Splash
- Login
- Início
- Lista de Receitas
- Detalhe da Receita
- Favoritos
- Perfil

## Navegação

A estrutura principal é:

**Splash → Login → Painel Principal**

O painel possui três abas:

1. Início
2. Receitas
3. Favoritos

A aba **Receitas** possui uma lista. Ao tocar em uma receita, o app abre a tela de detalhe passando o `receitaId` por uma rota type-safe.

## Requisitos da missão atendidos

### Rotas type-safe

Todas as rotas estão em `AppRoutes.kt`, usando:

- `sealed interface AppRoute`
- `@Serializable`
- `data object`
- `data class ReceitaDetalhe(val receitaId: Int)`

Não há rotas principais como Strings soltas.

### Navegação linear

A Splash espera um curto período e chama `onFinished()` automaticamente, sem botão.

### Navegação condicional

A Splash não decide para onde ir.

A decisão fica no componente que hospeda o `NavHost`, em `ReceitasApp.kt`:

```kotlin
val usuarioEstaLogado = false

navController.navigate(
    if (usuarioEstaLogado) AppRoute.Home else AppRoute.Login
)
```

### Parâmetro type-safe

A lista envia:

```kotlin
navController.navigate(AppRoute.ReceitaDetalhe(id))
```

E a tela de detalhe recupera:

```kotlin
val route = backStackEntry.toRoute<AppRoute.ReceitaDetalhe>()
```

Depois usa:

```kotlin
viewModel.buscarReceita(route.receitaId)
```

### Bottom Navigation persistente

As três abas usam juntas:

```kotlin
saveState = true
launchSingleTop = true
restoreState = true
```

A lista também utiliza `LazyListState.Saver` para preservar a posição da rolagem.

### ViewModel único

O `ReceitasViewModel` é criado uma única vez em `MainActivity` e passado para `ReceitasApp`.

As telas recebem o mesmo ViewModel por parâmetro e não criam `viewModel()` individualmente.

### Paleta própria

As cores ficam no arquivo:

`ui/theme/Color.kt`

E o esquema é definido em:

`ui/theme/Theme.kt`

usando `lightColorScheme(...)`.

As telas utilizam `MaterialTheme.colorScheme` em vez de declarar `Color(0xFF...)` diretamente.

### Estado vazio

A tela de receitas verifica se a lista está vazia e mostra uma mensagem informativa.

### Acessibilidade

Os ícones que representam ações possuem `contentDescription`.

## Como abrir no Android Studio

1. Extraia o arquivo `.zip`.
2. Abra o **Android Studio**.
3. Clique em **Open**.
4. Selecione a pasta `ReceitasApp`.
5. Aguarde o Gradle sincronizar.
6. Conecte um celular com depuração USB ou crie um emulador.
7. Clique no botão **Run ▶**.

## Estrutura principal

```text
ReceitasApp/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/receitasapp/
│           │   ├── data/
│           │   ├── model/
│           │   ├── navigation/
│           │   ├── ui/
│           │   │   ├── screens/
│           │   │   └── theme/
│           │   └── viewmodel/
│           └── res/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## GitHub

Depois de abrir e testar no Android Studio:

```bash
git init
git add .
git commit -m "Missão: app de receitas com navegação type-safe"
git branch -M main
git remote add origin URL_DO_SEU_REPOSITORIO
git push -u origin main
```

Substitua `URL_DO_SEU_REPOSITORIO` pelo endereço do seu repositório público.
