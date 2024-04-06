# AND101 Project 7 - CYOAPI Part 3: Beautified

Submitted by: **Brian Zhang**

Time spent: **4** hours spent in total

## Summary

**Pokedex** is an android app that **displays a scrollable list of Pokémon fetched from the PokéAPI, allows users to search for Pokémon by name, and dynamically loads more Pokémon as the user scrolls to the bottom of the list.**

If I had to describe this project in three (3) emojis, they would be: **🕵🏻‍♂️🦖👾**

## Application Features

The following REQUIRED features are completed:

- [X] App contains a RecyclerView that displays a list of scrollable data
- [X] App displays at least two (2) pieces of data for each RecyclerView item
- [X] Use a downloadable font with custom color and size
- [X] Modify the theme of the app in `themes.xml`
- [X] Define and apply at least one style in **either** `themes.xml` or a new file `styles.xml`

The following STRETCH features are implemented:

- [X] Update the night theme to use different versions of styles when in dark mode
- [X] Use different drawables when in dark mode

## Video Demo

Here's a video / GIF that demos all of the app's implemented features:
<p align = center>
    <img src='https://imgur.com/OTicZeJ.gif' title='Video Demo' width='' alt='Video Demo' />
</p>
GIF created with **ScreenToGif**

<!-- Recommended tools:
- [Kap](https://getkap.co/) for macOS
- [ScreenToGif](https://www.screentogif.com/) for Windows
- [peek](https://github.com/phw/peek) for Linux. -->

## Notes

- **Fetching Data from an API:** Utilizes AsyncHttpClient for asynchronous data fetching from PokéAPI.
- **RecyclerView and Adapter Implementation:** Implements RecyclerView and custom PetAdapter for displaying Pokémon lists.
- **Custom Item Decoration for RecyclerView:** Adds CustomDividerItemDecoration for custom dividers in RecyclerView.
- **Search Functionality:** Incorporates SearchView for searching Pokémon by name.
- **Infinite Scrolling Mechanism:** Implements infinite scrolling with addOnScrollListener for RecyclerView.
- **Dynamic UI Updates:** Dynamically updates UI with new Pokémon data and notifies adapter.
- **Styling and Theming:** Defines custom XML styles and dark mode theme for UI consistency.
- **Spannable Strings for Text Styling:** Uses SpannableStringBuilder and ForegroundColorSpan for dynamic text coloring.
- **Efficient Image Loading:** Leverages Glide for efficient image loading and display.
- **Handling Click Events:** Handles click events in PetAdapter with feedback via Toast messages.

## License

Copyright **2024** **Brian Zhang**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
