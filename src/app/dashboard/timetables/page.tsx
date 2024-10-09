import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select"

export default function TimetablesPage() {
  return (
    <div className="space-y-6">
      <h1 className="text-3xl font-bold text-black">Timetables</h1>
      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">Generate Timetable</CardTitle>
          <CardDescription className="text-gray-600">Create a new timetable for a class or teacher.</CardDescription>
        </CardHeader>
        <CardContent>
          <div className="flex space-x-4">
            <Select>
              <SelectTrigger className="w-[180px] bg-white text-black border-gray-300">
                <SelectValue placeholder="Select Type" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="class">Class Timetable</SelectItem>
                <SelectItem value="teacher">Teacher Timetable</SelectItem>
              </SelectContent>
            </Select>
            <Button className="bg-blue-600 text-white hover:bg-blue-700">Generate Timetable</Button>
          </div>
        </CardContent>
      </Card>

      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">View Timetables</CardTitle>
          <CardDescription className="text-gray-600">Access and view existing timetables.</CardDescription>
        </CardHeader>
        <CardContent>
          <div className="space-y-4">
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">Class 1 Timetable</span>
              <Button variant="outline" className="text-blue-600 border-blue-600 hover:bg-blue-50">View</Button>
            </div>
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">Class 2 Timetable</span>
              <Button variant="outline" className="text-blue-600 border-blue-600 hover:bg-blue-50">View</Button>
            </div>
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">Teacher A Timetable</span>
              <Button variant="outline" className="text-blue-600 border-blue-600 hover:bg-blue-50">View</Button>
            </div>
          </div>
        </CardContent>
      </Card>
    </div>
  )
}