package com.rafikconsole.githubprofile.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color




val DarkAppBackgroundColor = Color(0xFF0D1117) // Main background color
val DarkErrorColor = Color(0xFFF33333) // Error color (red)
val DarkTextColor = Color(0xFFaFaFaF) // Text color
val DarkTitleColor = Color(0xFFF0F6FC) // Title color
val DarkYesHireableColor = Color(0xFF3FB950) // Hireable color (green)
val DarkNoHireableColor = Color(0xFFA4393A) // Not hireable color (red)
val DarkHorizontalDividerColor = Color(0xFF151B23) // Divider color
val DarkImageBackgroundColor = Color(0xFF0D1117) // Background for images
val DarkRepositoryItemBackgroundColor = Color(0xFF141D25) // Background for repository items
val DarkButtonColor = Color(0xFF713FC8) // Button colo


val LightAppBackgroundColor = Color(0xFF0D1117) // Main background color
val LightErrorColor = Color(0xFFF33333) // Error color (red)
val LightTextColor = Color(0xFF8B949E) // Text color
val LightTitleColor = Color(0xFFF0F6FC) // Title color
val LightYesHireableColor = Color(0xFF3FB950) // Hireable color (green)
val LightNoHireableColor = Color(0xFFA4393A) // Not hireable color (red)
val LightHorizontalDividerColor = Color(0xFF151B23) // Divider color
val LightImageBackgroundColor = Color(0xFF0D1117) // Background for images
val LightRepositoryItemBackgroundColor = Color(0xFF141D25) // Background for repository items
val LightButtonColor = Color(0xFF713FC8) // Button color




val AppBackgroundColor: Color
    @Composable
    get()= if( isSystemInDarkTheme())  DarkAppBackgroundColor else LightAppBackgroundColor

val ButtonColor: Color
    @Composable
    get()= if( isSystemInDarkTheme())  DarkButtonColor else LightButtonColor

val ErrorColor: Color
    @Composable
    get()= if( isSystemInDarkTheme())  DarkErrorColor else LightErrorColor

val TextColor: Color
    @Composable
    get()= if( isSystemInDarkTheme())  DarkTextColor else LightTextColor

val TitleColor: Color
    @Composable
    get()= if( isSystemInDarkTheme())  DarkTitleColor else LightTitleColor

val YesHireableColor: Color
    @Composable
    get()= if( isSystemInDarkTheme())  DarkYesHireableColor else LightYesHireableColor

val NoHireableColor: Color
    @Composable
    get()= if( isSystemInDarkTheme())  DarkNoHireableColor else LightNoHireableColor

val HorizontalDividerColor: Color
    @Composable
    get()= if( isSystemInDarkTheme())  DarkHorizontalDividerColor else LightHorizontalDividerColor

val ImageBackgroundColor: Color
    @Composable
    get()= if( isSystemInDarkTheme())  DarkImageBackgroundColor else LightImageBackgroundColor

val RepositoryItemBackgroundColor: Color
    @Composable
    get()= if( isSystemInDarkTheme())  DarkRepositoryItemBackgroundColor else LightRepositoryItemBackgroundColor

val languageColors = mapOf(
    "Kotlin" to Color(0xFF7F52FF),
    "Java" to Color(0xFFB07219),
    "Python" to Color(0xFF3572A5),
    "JavaScript" to Color(0xFFF1E05A),
    "C" to Color(0xFF555555),
    "C++" to Color(0xFFF34B7D),
    "C#" to Color(0xFF178600),
    "Go" to Color(0xFF00ADD8),
    "Ruby" to Color(0xFF701516),
    "PHP" to Color(0xFF4F5D95),
    "Swift" to Color(0xFFFFAC45),
    "TypeScript" to Color(0xFF2B7489),
    "HTML" to Color(0xFFE34C26),
    "CSS" to Color(0xFF563D7C),
    "Shell" to Color(0xFF89E051),
    "Scala" to Color(0xFFDC322F),
    "Rust" to Color(0xFFDEA584),
    "Dart" to Color(0xFF00B4AB),
    "Objective-C" to Color(0xFF438EFF),
    "R" to Color(0xFF198CE7),
    "Perl" to Color(0xFF0298C3),
    "Haskell" to Color(0xFF5E5086),
    "Elixir" to Color(0xFF6E4A7E),
    "V" to Color(0xFF5D87BF),
    "CoffeeScript" to Color(0xFF244776),
    "PowerShell" to Color(0xFF012456),
    "Lua" to Color(0xFF000080),
    "Matlab" to Color(0xFFA35E00),
    "Groovy" to Color(0xFFE69F56),
    "Vim script" to Color(0xFF199F4B),
    "Erlang" to Color(0xFFA90533),
    "F#" to Color(0xB845FC),
    "Vala" to Color(0xFF3585A2),
    "Julia" to Color(0xFF9558B2),
    "D" to Color(0xFFBA595E),
    "Fortran" to Color(0xFF4D41B1),
    "Roff" to Color(0xFFECDEBE),
    "Tcl" to Color(0xFFE4CC98),
    "TeX" to Color(0xFF3D6117),
    "Handlebars" to Color(0xFFf7931e),
    "Mustache" to Color(0xFF724b3b),
    "Pascal" to Color(0xFFE3F171),
    "OCaml" to Color(0xFF3BE133),
    "Smalltalk" to Color(0xFF596706),
    "Assembly" to Color(0xFF6E4C13),
    "Makefile" to Color(0xFF427819),
    "Verilog" to Color(0xFFB2B7F8),
    "VHDL" to Color(0xFFADB2CB),
    "Scheme" to Color(0xFF1E4AEC)
)