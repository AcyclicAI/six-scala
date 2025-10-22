# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

**six-scala** is a multi-module Scala 3 project that provides interoperability infrastructure for Scala 3 upgrades. The project focuses on serialization utilities, build system optimization, and migration tools for large-scale Scala codebases.

## Build System

This project uses Gradle with a sophisticated custom build system:

### Common Commands

**Building and Testing:**
```bash
# Build entire project
./gradlew build

# Run all tests
./gradlew test
# Or use convenience script
./dev/test.sh

# Build specific module
./gradlew :six:typetag:build
./gradlew :six:spark:build

# Run tests for specific module
./gradlew :six:typetag:test
```

**Code Quality:**
```bash
# Format code and run scalafix (use this - memory intensive)
./dev/format-code.sh

# Update Gradle wrapper and check dependencies
./dev/gradle-versions.sh
```

**Development Tasks:**
```bash
# Clean build
./gradlew clean

# Assemble JARs
./gradlew assemble

# Run all checks
./gradlew check
```

### Project Structure

```
six-scala/
├── :six (main module)
│   ├── :six:typetag    # Serialization infrastructure using Boopickle
│   ├── :six:spark      # Apache Spark serialization utilities
│   └── :six:unused     # Experimental code
├── buildSrc/           # Custom Gradle plugins and build utilities
└── dev/               # Development scripts
```

## Module Architecture

### Core Modules

**`:six:typetag`** - Serialization infrastructure
- Provides compile-time serialization using Boopickle
- Contains `BoopickleLowering` for code generation
- Foundation for other modules

**`:six:spark`** - Apache Spark integration
- Serialization validation utilities
- Testing helpers for Spark serialization
- Depends on typetag module

**`:six:unused`** - Experimental features
- Placeholder for experimental code
- Depends on typetag module

### Build System Architecture

The project uses custom Gradle plugins defined in `buildSrc/`:
- `scala3-conventions`: Scala 3 specific build configurations
- `scalatest-mixin`: Testing framework integration
- `publish-conventions`: Publishing and release management

## Development Notes

### Scala 3 Specific Features
- Uses Scala 3 macros and quotes (`Quotes` API)
- Leverages `given/using` syntax for implicits
- Type-level programming and metaprogramming capabilities

### Serialization Focus
- Heavy emphasis on compile-time serialization
- Boopickle integration for efficient serialization
- Base64 encoding for embedded serialized data

### Memory Considerations
- Code formatting (`scalafix`) is memory intensive
- Run with `-Dorg.gradle.parallel=false` for scalafix tasks
- Use `./dev/format-code.sh` for proper formatting sequence

## Testing

Tests are organized per-module. Use `./gradlew :six:typetag:test` for module-specific testing. The project includes serialization testing utilities for validating Spark compatibility.

## Template System

New modules can be created using the `:six:__template` directory as a starting point for consistent module structure and build configuration.