# Expected behaviour:
- User opens app (fragment A)
- User navigates to Login (no back button shown on toolbar)
- User clicks back (native back (ONLY OPTION))
- App closes

# Actual behavior:

 - User opens app (fragment A)
 - User navigates to Login -> back button keep being shown
 - User clicks back
   - User clicks native back -> app closes as expected
   - User clicks toolbar back button -> it goes to fragment A
